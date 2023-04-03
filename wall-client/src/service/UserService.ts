import config from '../config/ApiConfig';
import { requestHelper } from './http';

class UserService {
    private BASE_URL = config.BASE_URL;
    private login = 'login';
    private register = 'user/register';


    async loginUser(email: string, password: string) {
        const path = this.login
        const body = { email, password }
        try {
            const res = await requestHelper('post', path, body)
            return res
        } catch (error: any) {
            throw new Error(error.response);

        }


    }
    async registerUser(email: string, password: string, username: string) {
        const url = this.BASE_URL + '/' + this.register
        const body = { email, password, username }
        return await requestHelper('post', url, body)
    }





}

export default UserService;