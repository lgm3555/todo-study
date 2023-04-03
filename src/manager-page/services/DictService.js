import axios from 'axios';
import {
    SET_DANAWA_KWD_DICT,
    SET_ENURI_KWD_DICT,
    SET_DANAWA_ANG_DICT,
    SET_ENURI_ANG_DICT
} from "./constants";

export const getDKwdDictData = () => {
    return axios.get(`/danawa/dict/kwd`)
        .then(response => ({type: SET_DANAWA_KWD_DICT, payload: response.data}))
        .catch(err => console.error(err))}

export const getEKwdDictData = () => {
    return axios.get(`/enuri/dict/kwd`)
        .then(response => ({type: SET_ENURI_KWD_DICT, payload: response.data}))
        .catch(err => console.error(err))}

export const getDAngDictData = () => {
    return axios.get(`/danawa/dict/ang`)
        .then(response => ({type: SET_DANAWA_ANG_DICT, payload: response.data}))
        .catch(err => console.error(err))}

export const getEAngDictData = () => {
    return axios.get(`/enuri/dict/ang`)
        .then(response => ({type: SET_ENURI_ANG_DICT, payload: response.data}))
        .catch(err => console.error(err))}