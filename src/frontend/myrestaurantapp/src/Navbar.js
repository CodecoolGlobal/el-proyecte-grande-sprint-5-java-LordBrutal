import NavbarListItem from "./components/NavbarListItem";
import logo from "./images/logomain.svg"
import {getUserToken} from "./services/AuthService";
import {useLocation} from "react-router-dom";

function Navbar() {

    const location = useLocation();

    return (
        <div>
            <div className="header-navbar">
                <ul>
                    { getUserToken() ? (<div><li><a href="/logout">Logout</a></li>
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
        </div>
)
}

export default Navbar;