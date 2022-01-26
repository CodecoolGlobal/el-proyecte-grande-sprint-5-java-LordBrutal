import Ingredients from "./pages/Ingredients";
import {useState} from "react";

function Navbar() {
    return (
        <div>
            <div className="header-navbar">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/ingredient">Add ingrediement</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">About</a></li>
                </ul>
            </div>
        </div>
)
}

export default Navbar;