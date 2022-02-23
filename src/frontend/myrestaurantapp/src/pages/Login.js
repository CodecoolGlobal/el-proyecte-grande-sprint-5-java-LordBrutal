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

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault()
        login(formData.username, formData.password).then(r => history('/'))
    };

    return (
        <div>
            <div className="form-container">
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
            </div>
        </div>
    );
}

export default Login;