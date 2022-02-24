import error from "../images/error.svg";
import {validateRoleUser} from "../services/UserRolesValidation";


function PageNotFound() {
    return (<div className="center-img">
        <img className="error-logo animation-left" src={error} alt=""/>
        {!validateRoleUser() ?
            <h1 className="error-text animation-top">This page is not available, login <a href="/login">here</a> !
            </h1> :
            <h1 className="error-text animation-top">This page is not available for you <a href="/">go back</a></h1>}
    </div>)
}

export default PageNotFound