import React from "react";
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

const validateRoleAdmin = () => {
    const jwt = getUserToken();
    if (jwt !== "") {
        const decoded = jwt_decode(jwt);
        return decoded.roles.includes("ROLE_ADMIN")
    }
    return false
}


export {validateRoleUser, validateRoleAdmin};