import axios from 'axios';
import Client from "../utils/Client";

const client = new Client();

export const productCategory = (categoryCode) => {
    return axios.get(`/product/category/${categoryCode}`);
}

export const orderHistory = () => {
    return client.call({
        url: `/order`,
        method: `get`
    })
}

export const orderHistoryDetail = (orderSeq) => {
    return client.call({
        url: `/order/${orderSeq}`,
        method: `get`,
        data: orderSeq
    })
}