import {useEffect, useState} from "react";

function SelectReceipt() {
        const [receipt, setReceipt] = useState({isLoaded: false});
        useEffect(() => {
            fetch("http://localhost:8080/api/get-all-receipt")
                .then(response => response.json())
                .then(
                    (result) => {
                        setReceipt({data : result, isLoaded: true})
                    },
                    (error) => {
                        setReceipt({
                            isLoaded: true,
                            error
                        });
                    }
                )
        },[]);

        if (receipt.isLoaded && receipt.error === undefined){
            return (<div><select className="select-dropdown" name="food" id="selects">
                {receipt.data.map((row, index) => (
                    <option key={index} value={row.name}>{row.name} {row.price}</option>
                ))}
            </select></div>)
        }
        return (<div><select className="select-dropdown" name="ingredient" id="selects">
            <option  value="">""</option>
        </select></div>)
}

export default SelectReceipt;