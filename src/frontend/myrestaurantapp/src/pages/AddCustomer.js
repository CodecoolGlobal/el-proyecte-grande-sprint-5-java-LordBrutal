import React, {useState} from "react";
import {saveUser} from "../services/CustomerService";
import {useNavigate} from "react-router-dom";

function AddCustomer() {

    let history = useNavigate();

    const initialFormData = Object.freeze({
        name: "",
        email: "",
        phoneNumber: "",
    });

    const initialFormDataAdress = Object.freeze({
        cityName: "",
        streetName: "",
        houseNumber: ""
    });

    const [formData, updateFormData] = React.useState(initialFormData);
    const [formDataAdress, updateFormDataAdrees] = React.useState(initialFormDataAdress);


    const handleChange = (e) => {
        if (e.target.name === "cityName" || e.target.name === "streetName" || e.target.name === "houseNumber") {
            updateFormDataAdrees({
                ...formDataAdress,
                [e.target.name]: e.target.value.trim()
            });
        } else {
            updateFormData({
                ...formData,
                [e.target.name]: e.target.value.trim()
            });
        }
    };


    const handleSubmit = () => {
        let userJsonObject = {
            name: formData.name,
            email: formData.email,
            phoneNumber: formData.phoneNumber,
            address: {
                cityName: formDataAdress.cityName,
                streetName: formDataAdress.streetName,
                houseNumber: formDataAdress.houseNumber
            }
        }
        saveUser(userJsonObject).then(r => history('/'));
    }


    return (<div className="form-container animation-show">
        <div className="add-user-backround">
            <label className="label-text">Name<br/>
                <input className="label-input" type="text" width="100px" name="name" autoComplete="off"
                       onChange={handleChange} required/>
            </label><br/>
            <label className="label-text">Email<br/>
                <input className="label-input" type="text" name="email" autoComplete="off" onChange={handleChange}
                       required/>
            </label><br/>
            <label className="label-text">Phone Number<br/>
                <input className="label-input" type="text" name="phoneNumber" autoComplete="off" onChange={handleChange}
                       required/>
            </label><br/>
            <label className="label-text">City Name<br/>
                <input className="label-input" type="text" name="cityName" autoComplete="off" onChange={handleChange}
                       required/>
            </label><br/>
            <label className="label-text">Street Name<br/>
                <input className="label-input" type="text" name="streetName" autoComplete="off" onChange={handleChange}
                       required/>
            </label><br/>
            <label className="label-text">House Number<br/>
                <input className="label-input" type="number" name="houseNumber" autoComplete="off"
                       onChange={handleChange} required/>
            </label><br/>
            <button className="submit-button" onClick={handleSubmit}>Save me</button>
        </div>
    </div>)
}

export default AddCustomer;
