import axios from "axios";

const API_URL = "http://localhost:8080/api"

const login = async(username, password) => {
    const params = new URLSearchParams()
    params.append('username', username)
    params.append('password', password)
    const url = API_URL + "/login";
    const config = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }
    await axios.post(url, params, config)
        .then(response => {
            if (response.data.access_token) {
                localStorage.setItem("access_token", JSON.stringify(response.data.access_token));
            }
            // return response.data;
        });
}
const logout = () => {
    localStorage.removeItem("access_token");
}

const getUserToken = () => {
    if (localStorage.getItem('access_token') != null){
        return JSON.parse(localStorage.getItem('access_token'))
    }
    return "";
}