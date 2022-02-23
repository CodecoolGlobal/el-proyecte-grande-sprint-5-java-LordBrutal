import error from "../images/error.svg";


function PageNotFound() {
    return (<div className="center-img">
        <img className="error-logo animation-left" src={error} alt=""/>
        <h1 className="error-text animation-top">This page is not available, login <a href="/login">here</a> !</h1>
    </div>)
}

export default PageNotFound