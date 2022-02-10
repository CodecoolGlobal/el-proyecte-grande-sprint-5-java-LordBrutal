import SelectIngredient from "../SelectIngredient";

function Ingredients() {
    return (
        <div>
            <div className={"ingredients-container"}>
                <div className="form-container">
                    <div className="add-ingredient-baackround">
                        <form action="http://localhost:8080/api/add-ingredient" method="POST">
                            <label className="label-text">Ingredient name<br/>
                                <input className="label-input" type="text" name="name" autoComplete="off" required/>
                            </label><br/>
                            <label className="label-text">Price<br/>
                                <input className="label-input" type="number" name="price" autoComplete="off" required/>
                            </label><br/>
                            <label className="label-text">Type<br/>
                                <select className="select-dropdown" name="type">
                                    <option value="GRAM">gram</option>
                                    <option value="MILLILITRE">milliliter</option>
                                    <option value="PIECE">piece</option>
                                </select>
                            </label><br/>
                            <button className="submit-button" type="submit">Save me</button>
                        </form>
                    </div>
                </div>
                <div className="form-container">
                    <div className="add-ingredient-baackround">
                        <form action="http://localhost:8080/api/add-to-storage" method="POST">
                            <h1>Add ingredient to storage</h1>
                            <SelectIngredient/>
                            <button className="submit-button" type="submit">Save me</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>)
}

export default Ingredients;