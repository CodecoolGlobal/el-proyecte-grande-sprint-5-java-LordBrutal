import React from 'react';
import register from "../services/UserService";
import {useNavigate} from "react-router-dom";

function RegisterUser() {

    let history = useNavigate()

    const initialFormData = Object.freeze({
        username: "",
        password:"",
        role:"USER"
    })

    const [formData, updateFormData] = React.useState(initialFormData);
    const [failedRegistration, setFailedRegistration] = React.useState(false)

    const handleChange = (event) => {
        updateFormData({
            ...formData, [event.target.name]: event.target.value.trim()
        });
    };

    const clickHandler = async (event) => {
        event.preventDefault();
        const registerSuccess = await register(formData.username, formData.password, formData.role)
        if (registerSuccess) {
            history('/')
        } else {
            setFailedRegistration(true)
            setTimeout( () => {setFailedRegistration(false)}, 3000)
        }
    }
    return (
        <div>
            <div className="form-container animation-show">
                <div className="add-ingredient-backround">
                    <label className="label-text">User name<br/>
                        <input className="label-input" type="text" name="username" onChange={handleChange} autoComplete="off" required/>
                    </label><br/>
                    <label className="label-text">Password<br/>
                        <input className="label-input" type="password" name="password" onChange={handleChange} autoComplete="off" required/>
                    </label><br/>
                    <label className="label-text">Role<br/>
                        <select className="select-dropdown" name="role" onChange={handleChange}>
                            <option value="ROLE_USER">User</option>
                            <option value="ROLE_MANAGER">Manager</option>
                            <option value="ROLE_ADMIN">Admin</option>
                        </select>
                    </label><br/>
                    <button className="submit-button" onClick={clickHandler}>Register</button>
                </div>
                {failedRegistration && <div className="user-login-error animation-show">
                    <h1>User already exists!</h1>
                </div> }
            </div>
        </div>
    );
}

export default RegisterUser;