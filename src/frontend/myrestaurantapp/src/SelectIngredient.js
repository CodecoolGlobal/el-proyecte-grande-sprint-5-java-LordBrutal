function  SelectIngredient(){
    return (<select className="select-dropdown" name="price">
        <option value="GRAM">gram</option>
        <option value="MILLILITRE">milliliter</option>
        <option value="PIECE">piece</option>
    </select>)
}

export default SelectIngredient;