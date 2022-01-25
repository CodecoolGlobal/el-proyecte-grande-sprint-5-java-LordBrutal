import Ingredients from "./Ingredients";
import {useState} from "react";

function Navbar() {

    const [classChanger, chooseclass] = useState(["ingredients-hide", "ingredients-show"]);
    const [click, setCliccker] = useState(0);

    function addIngredient() {
        if (click === 0){
            setCliccker(click + 1);
        }
        else {
            setCliccker(click - 1);
        }
    }

    return (
        <div>
            <div className="header-navbar">
                <ul>
                    <li><a className="active" href="">Home</a></li>
                    <li><a href="#" onClick={addIngredient}>Add ingrediement</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="#about">About</a></li>
                </ul>
            </div>
            <Ingredients text={classChanger[click]}/>
        </div>
)
}

export default Navbar;