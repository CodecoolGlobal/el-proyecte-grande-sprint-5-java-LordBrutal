
function Ingredients(props) {
    return (<div className={props.text}>
        <form>
            <label>Name<input type="text" name="name" /></label>
            <button type="submit">Click me</button>
        </form>
    </div>)
}

export default Ingredients;