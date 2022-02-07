import SelectCustomer from "../components/SelectCustomer";
import SelectReceipt from "../components/SelectReceipt";
import {useState} from "react";

function AddNewOrder() {
    const [foodList, editFoodList] = useState([<SelectReceipt/>])
    const listItems = foodList.map((item, index) =>
        <div key={index}>      {item}
        </div>
    );
    function addFood(){
        editFoodList(prevArray => [...prevArray, <SelectReceipt/>])
    }
    return (
        <div className={"add-ingredient-container"}>
            <h1 className={"page-title"}>Add new order</h1>
            <div className={"add-ingredient-baackround"}>
                <form action="http://localhost:8080/api/add-order" method="POST">
                    <label className="label-text">
                        Customer name and phone number
                        <br/><SelectCustomer/>
                    </label><br/>
                    <label className="label-text">
                        Add foods to the order
                    </label><br/>
                    {listItems}
                    <button type="button" className="add-button" onClick={addFood}>Add food</button>

                    <button className="submit-button" type="submit">Save order</button>
                </form>
            </div>
        </div>
    );
}

export default AddNewOrder;