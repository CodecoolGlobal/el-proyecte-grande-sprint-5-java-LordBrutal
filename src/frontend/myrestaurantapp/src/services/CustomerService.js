import axios from "axios";

const API_URL = "http://localhost:8080/api"

const saveUser = async (userDetails) => {
    const url = API_URL + "/add-customer";
    const res = await axios.post(url, userDetails, {
        headers: {
            'Content-Type': 'application/json'
        }
    });
}

export {saveUser}
