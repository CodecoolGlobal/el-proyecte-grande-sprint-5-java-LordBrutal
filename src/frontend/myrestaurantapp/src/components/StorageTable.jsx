import { useEffect, useState } from "react";
import AuthHeader from "../services/AuthHeader";
import axios from "axios";


function StorageTable(props) {
    const [ingredient, setIngredient] = useState({isLoaded: false});
    useEffect(() => {
        const config = {
            headers: AuthHeader()
        }
        const url = "http://localhost:8080/api/storage/items"
        axios.get(url, config)
            .then(
                (result) => {
                    setIngredient({data : result.data, isLoaded: true})
                },
                (error) => {
                    setIngredient({
                        isLoaded: true,
                        error
                    });
                }
            )
    },[]);

    if (ingredient.isLoaded && ingredient.error === undefined) {
        return (
            <div className={"storage-container"}>
                <table className={"storage-table"}>
                    <thead>
                        <tr>
                            <th>Ingredient name</th>
                            <th>Ingredient quantity</th>
                            <th>Unit of Measure</th>
                        </tr>
                    </thead>
                    <tbody>
                    { ingredient.data.map((row, index) => (
                        <tr>
                            <td key={index+1}>{row.ingredient.name}</td>
                            <td key={index+2}>{row.quantity}</td>
                            <td key={index+3}>{row.ingredient.unitType}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        )
    }
    else {
        return <div></div>
    }
}

export default StorageTable;