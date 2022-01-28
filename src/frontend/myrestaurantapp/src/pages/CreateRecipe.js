import SelectIngredient from "../SelectIngredient";
import {useState} from "react";

function CreateRecipe() {

    const [selectList, editList] = useState([<SelectIngredient/>])
    const listItems = selectList.map((item, index) =>
        <div key={index}>      {item}
        </div>
    );
    function add(){
        editList(prevArray => [...prevArray, <SelectIngredient/>])
    }

    return (<div className="add-ingredient-container">
        <div className="add-ingredient-baackround">
            <form action="http://localhost:8080/api/add-receipt" method="POST">
                <label className="label-text">
                    Reciept Name
                    <br/><input className="label-input" type="text" name="name" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">
                    Price
                    <br/><input className="label-input" type="number" name="price" autoComplete="off" required/>
                </label><br/>
                    {listItems}
                    <button type="button" className="add-button" onClick={add}>+</button>

                <button className="submit-button" type="submit">Save me</button>
            </form>
        </div>
    </div>)
}

export default CreateRecipe;