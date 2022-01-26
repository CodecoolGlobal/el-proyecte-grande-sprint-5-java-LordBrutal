function Ingredients() {
    return (
        <div className="add-ingredient-container">
            <div className="add-ingredient-baackround">
                <form action="http://localhost:8080/api/add-ingredient" method="POST">
                    <label className="label-text">Ingredient name<br/>
                        <input  className="label-input" type="text" name="name" required/>
                    </label><br/>
                    <label className="label-text">Price<br/>
                        <input className="label-input" type="text" name="price" required/>
                    </label><br/>
                    <label className="label-text">Type<br/>
                        <select className="select-dropdown" name="price">
                            <option value="GRAM">gram</option>
                            <option value="MILLILITRE">milliliter</option>
                            <option value="PIECE">piece</option>
                        </select>
                    </label><br/>
                    <button className="submit-button" type="submit">Save me</button>
                </form>
            </div>
    </div>)
}

export default Ingredients;