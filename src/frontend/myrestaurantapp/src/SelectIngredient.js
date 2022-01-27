function  SelectIngredient(){
    const json = [
        {
            "name": "pepper",
            "price": 200,
            "quantity": "GRAM"
        },
        {
            "name": "egg",
            "price": 1400,
            "quantity": "PIECE"
        },
        {
            "name": "red wine",
            "price": 5000,
            "quantity": "MILLILITRE"
        },
        {
            "name": "salt",
            "price": 200,
            "quantity": "GRAM"
        },
        {
            "name": "flour",
            "price": 310,
            "quantity": "GRAM"
        },
        {
            "name": "beef",
            "price": 8000,
            "quantity": "GRAM"
        }
    ]

    return (<div><select className="select-dropdown" name="ingredient" id="slects">
        {json.map((row,index) => (
            <option key={index} value={row.name}>{row.name}</option>
        ))}
    </select>
        <label><input className="piece-input" type="number" name="quantity" /></label></div>)
}

export default SelectIngredient;