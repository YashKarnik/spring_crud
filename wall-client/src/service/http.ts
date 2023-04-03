import axios from 'axios';
import config from '../config/ApiConfig';



async function requestHelper(method: 'get' | 'post' | 'put' | 'delete', path: string, body?: any) {
    const { BASE_URL } = config
    const url = `${BASE_URL}/${path}`
    const axiosrequestConfig = {
        withCredentials: true
    }

    switch (method) {
        case 'get':
            return await axios.get(url, axiosrequestConfig)
        case 'post':
            return await axios.post(url, body, axiosrequestConfig)
        case 'put':
            return await axios.put(url, body, axiosrequestConfig)
        case 'delete':
            return await axios.delete(url, axiosrequestConfig)

    }

}

export { requestHelper }