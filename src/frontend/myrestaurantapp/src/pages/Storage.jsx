import SelectIngredient from "../SelectIngredient";
import StorageTable from "../components/StorageTable";


function Storage() {
    return (
        <div className="form-container">
            <div className="add-ingredient">
                <form action="http://localhost:8080/api/add-to-storage" method="POST">
                    <h3>Select the ingredient you want to add to the storage</h3>
                    <SelectIngredient/>
                    <button className="submit-button" type="submit">Add</button>
                </form>
            </div><br/><br/>
            <StorageTable/>
        </div>

    )
}

export default Storage;