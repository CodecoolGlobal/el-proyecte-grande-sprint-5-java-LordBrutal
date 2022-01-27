import {useEffect, useState} from "react";
import OrderFoodsList from "../components/OrderFoodsList";


function ActiveOrders(props) {

    const [jsonResult, setJson] = useState({isLoaded: false});
    useEffect(() => {
        fetch("http://localhost:8080/api/get-orders")
            .then(res => res.json())
            .then(
                (result) => {
                    setJson({data : result, isLoaded: true})
                },
                (error) => {
                    setJson({
                        isLoaded: true,
                        error
                    });
                }
            )
    },[]);


    if (jsonResult.isLoaded && jsonResult.error === undefined) {
        return (
            <div className={"order-container"}>
                <ul>
                    {jsonResult.data.map((order, index) => (
                        <li key={index}><p>Order number: {order.id + 1}</p>
                            {order.customer.name} ( {order.customer.address.cityName}, {order.customer.address.streetName} {order.customer.address.houseNumber})
                            <p>Phone number: {order.customer.phoneNumber}</p>
                            <p>Ordered foods: </p>
                            <OrderFoodsList data={order.foods}/>
                            <p>Total price: {order.totalPrice}</p>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
    return (<h1>Hello</h1>);

}

export default ActiveOrders;