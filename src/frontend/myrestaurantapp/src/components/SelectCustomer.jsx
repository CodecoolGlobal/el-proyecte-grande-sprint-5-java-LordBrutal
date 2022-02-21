import {useEffect, useState} from "react";

function SelectCustomer() {
    const [customer, setCustomer] = useState({isLoaded: false});
    useEffect(() => {
        fetch("http://localhost:8080/api/get-all-customer")
            .then(response => response.json())
            .then(
                (result) => {
                    setCustomer({data : result, isLoaded: true})
                },
                (error) => {
                    setCustomer({
                        isLoaded: true,
                        error
                    });
                }
            )
    },[]);

    if (customer.isLoaded && customer.error === undefined){
        return (<div><select className="select-dropdown" name="customer" id="selects">
            {customer.data.map((row, index) => (
                <option key={index} value={row.id}>{row.name} ({row.phoneNumber})</option>
            ))}
        </select></div>)
    }
    return (<div><select className="select-dropdown" name="ingredient" id="selects">
        <option  value="">""</option>
    </select></div>)
}

export default SelectCustomer;