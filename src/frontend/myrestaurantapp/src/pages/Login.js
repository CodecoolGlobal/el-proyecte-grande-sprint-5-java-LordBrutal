import React, {useEffect, useState} from "react";
import {login} from "../services/AuthService.js"
import {useNavigate} from "react-router-dom";


function Login() {
    let history = useNavigate();

    const initialFormData = Object.freeze({
        username: "",
        password: ""
    });

    const [formData, updateFormData] = React.useState(initialFormData);
    const [loginResult, setLoginResult] = React.useState(false)

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault()
        const loginStatus = await login(formData.username, formData.password)
        if (loginStatus){
            history('/')
        }else {
            setLoginResult(true)
            setTimeout( funt => {setLoginResult(false)}, 3000);
        }

    };
    return (
        <div>
            <div className="form-container animation-show">
                <div className="user-login">
                    <label className="label-text">
                        Username
                        <input className="label-input" type="text" name="username" onChange={handleChange}/>
                    </label>
                    <br/>
                    <label className="label-text">
                        Password
                        <input className="label-input" type="password" name="password" onChange={handleChange}/>
                    </label>
                    <br/>
                    <button className="submit-button" onClick={handleSubmit}>Submit</button>
                </div>
                {loginResult && <div className="user-login-error animation-show">
                    <h1>Invalid username or password</h1>
                </div>}
            </div>
        </div>
    );
}

export default Login;
