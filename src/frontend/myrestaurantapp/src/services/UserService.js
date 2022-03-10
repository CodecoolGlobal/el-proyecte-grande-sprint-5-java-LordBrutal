import axios from "axios";

const API_URL = "http://localhost:8080/api"

const register = async(username, password, role) => {
    let registerSuccess;

    const json = {name: username,password: password}
    const roleJson = {username: username, role: role}


    const urlRegister = API_URL + "/user/register"
    const urlAddRole = API_URL + "/user/add-role"
    const config = {
        headers: {
            'Content-Type': 'application/json'
        }

    }

    await axios.post(urlRegister, json, config)
        .then(response => {
            if(response.status === 200) {
                registerSuccess = true
                axios.put(urlAddRole, roleJson, config)
                    .then(response => {
                        if (response.status === 200) {
                            console.log('Role added')
                        }
                    })
            }
        });

    return registerSuccess;
}

export default register;