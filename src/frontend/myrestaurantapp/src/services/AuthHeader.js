import {getUserToken} from "./AuthService";

function AuthHeader(){
    const user = JSON.parse(localStorage.getItem('access_token'));
    if (user) {
        return { "Authorization": 'Bearer ' + getUserToken() };
    } else {
        return {};
    }
}

export default AuthHeader