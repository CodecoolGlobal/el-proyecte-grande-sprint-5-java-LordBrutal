import {useEffect, useState} from "react";

function SelectIngredient() {
    const [jsn, setjsn] = useState({isLoaded: false});
    useEffect(() => {
        fetch("http://localhost:8080/api/get-all-ingredient")
            .then(res => res.json())
            .then(
                (result) => {
                    setjsn({data : result, isLoaded: true})
                },
                (error) => {
                    setjsn({
                        isLoaded: true,
                        error
                    });
                }
            )
    },[]);

    if (jsn.isLoaded && jsn.error === undefined){
        return (<div><select className="select-dropdown" name="ingredient" id="slects">
            {jsn.data.map((row, index) => (
                <option key={index} value={row.name}>{row.name}</option>
            ))}
        </select>
            <label><input className="piece-input" type="number" name="quantity" required/></label></div>)
    }
    return (<div><select className="select-dropdown" name="ingredient" id="slects">
            <option  value="">""</option>
    </select>
        <label><input className="piece-input" type="number" name="quantity"/></label></div>)
}

export default SelectIngredient;