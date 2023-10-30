import * as React from 'react';
import {AUTH_ACCESS_TOKEN, AUTH_REFRESH_TOKEN} from "./constrants";
import axios from "axios";

class Client {
    async call(config) {
        const authAccessToken = localStorage.getItem(AUTH_ACCESS_TOKEN);
        const authRefreshToken = localStorage.getItem(AUTH_REFRESH_TOKEN);

        if (authAccessToken) {
            config.headers = Object.assign(config.headers||{}, {
                "Authorization": `Bearer ${authAccessToken}`
            })
        } else if (authRefreshToken) {
            config.headers = Object.assign(config.headers||{}, {
                "Authorization": `Bearer ${authRefreshToken}`
            })
        }

        if (!authRefreshToken && config.url == '/auth/refresh') {
            return false;
        }

        return new Promise(async (resolve, reject) => {
            try {
                let response = await axios.request(config);
                let accessToken = (response['data'] || {})['accessToken']
                let refreshToken = (response['data'] || {})['refreshToken']

                if (accessToken) {
                    localStorage.setItem(AUTH_ACCESS_TOKEN, accessToken)
                }
                if (refreshToken) {
                    localStorage.setItem(AUTH_REFRESH_TOKEN, refreshToken)
                }
                resolve(response)
            } catch (error) {
                reject(error)
            }
        });
    }
}

export default Client;