import {useEffect, useState} from "react";
import OrderFoodsList from "../components/OrderFoodsList";
import Button from "../components/Button";


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
            <div >
                <h1 className={"page-title"}>Active orders</h1>
                <ul>
                    {jsonResult.data.map((order, index) => (
                        <li className={"order-container"} key={index}><p>Order number: {order.id + 1}</p>
                            <p>Order time: {order.formattedDateTime}</p>
                            {order.customer.name} ( {order.customer.address.cityName}, {order.customer.address.streetName} {order.customer.address.houseNumber})
                            <p>Phone number: {order.customer.phoneNumber}</p>
                            <p>Ordered foods: </p>
                            <OrderFoodsList data={order.foods}/>
                            <p>Total price: {order.totalPrice} HUF</p>
                            <Button className={"order-button add-button"} text={"Delete order"} url={`http://localhost:8080/api/delete-order/${order.id}`}/>
                            <Button className={"order-button add-button"} text={"Fulfilled"} url={`http://localhost:8080/api/change-order-status/${order.id}`}/>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
    return (<h1>Hello</h1>);

}

export default ActiveOrders;