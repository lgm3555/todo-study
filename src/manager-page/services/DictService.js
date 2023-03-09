import axios from 'axios';

export const getDanawaDictData = (dictType) => {
    return axios.get(`http://localhost:8080/danawa/dict/${dictType}`)
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log(error);
        });
}

export const getEnuriDictData = (dictType) => {
    return axios.get(`http://localhost:8080/enuri/dict/${dictType}`)
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.log(error);
        });
}