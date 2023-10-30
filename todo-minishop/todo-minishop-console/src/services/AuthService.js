import axios from 'axios';
import Client from "../utils/Client"

const client = new Client();

export const signUp = (id, password, name, email, phone, address) => {
    return axios.post("/auth/sign-up", {
        id:          `${id}`,
        password:    `${password}`,
        name:        `${name}`,
        email:       `${email}`,
        phone:       `${phone}`,
        address:     `${address}`,
    })
}

export const signIn = (data) => {
    return client.call({
        url: `/auth/sign-in`,
        method: `post`,
        data: data
    }).catch(err => {

    })
};

export const findPwd = (id, email) => {
    return axios.post("/auth/find-pwd", {
        id: `${id}`,
        email: `${email}`
    })
}

export const refresh = () => {
    return client.call({
        url: `/auth/refresh`,
        method: `get`
    }).catch(err => {

    })
}

export const check = () => {
    return client.call({
        url: `/auth/user`,
        method: `get`
    }).catch(err => {

    })
}

export const authInfo = () => {
    return client.call({
        url: `/auth/info`,
        method: `get`
    }).catch(err => {

    })
}