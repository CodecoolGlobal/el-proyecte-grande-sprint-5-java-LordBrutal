import NavbarListItem from "./components/NavbarListItem";
import logo from "./images/logomain.svg"
import {useLocation} from "react-router-dom";
import {validateRoleUser} from "./services/UserRolesValidation";
import {logout} from "./services/AuthService";

function Navbar() {

    const location = useLocation();
    let errorPage = false;
    const routes = ["/logout","/ingredient", "/create-recipe", "/create-customer", "/create-order", "/list-active-orders", "/login", "/"]
    const defaultRutes = ["/login", "/"]
    if (routes.indexOf(useLocation().pathname) === -1){
        errorPage = true;
    }

    if (!errorPage){
        if(!validateRoleUser() && defaultRutes.indexOf(location.pathname) === -1){
            return (<div></div>)
        }else {
            return (
                <div>
                    <div className="header-navbar">
                        <ul>
                            {validateRoleUser() ? (<div><li><a href="/" onClick={logout}>Logout</a></li>
                                <li><a href="/ingredient">Add ingredient</a></li>
                                <li><a href="/create-recipe">Create recipe</a></li>
                                <li><a href="/create-customer">Add Customer</a></li>
                                <NavbarListItem url={"/create-order"} text={"Add new order"}/>
                                <NavbarListItem url={"/list-active-orders"} text={"Active orders"}/>
                                <li><a href="#">About</a></li></div>) : location.pathname === "/login" ? null :(<li><a href="/login">Login</a></li> )}
                            <li id="logo-left" className="animation-top"><img className="main-logo" src={logo} alt="logo"/></li>
                            <li id="left-logo-text"  className="animation-top"><a href="/">My Restaurant</a></li>
                        </ul>
                    </div>
                </div>)}
    }else return (<div></div>)
}

export default Navbar;