import React, {useState} from "react";
import jwt_decode from "jwt-decode";
import {getUserToken} from "./AuthService";



const validateRoleUser = () =>{
    const jwt = getUserToken()
    if (jwt !== ""){
        const decoded = jwt_decode(jwt);
        return decoded.roles.includes("ROLE_USER")
    }
    return false
}


export {validateRoleUser};