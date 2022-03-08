import {useEffect, useState} from "react";
import OrderFoodsList from "../components/OrderFoodsList";
import Button from "../components/Button";
import Collapsible from "../components/Collapsible";
import AuthHeader from "../services/AuthHeader";
import axios from "axios";
import CircleLoader from "../components/CircleLoader";


function ActiveOrders(props) {

    const [jsonResult, setJson] = useState({isLoaded: false});
    useEffect(() => {
        const config = {
            headers: AuthHeader()
        }
        const url = "http://localhost:8080/api/get-orders"
        axios.get(url, config)
            .then(
                (result) => {
                    setJson({data: result.data, isLoaded: true})
                },
                (error) => {
                    setJson({
                        isLoaded: true,
                        error
                    });
                }
            )
    }, []);

    if (jsonResult.isLoaded && jsonResult.error === undefined) {
        return (
            <div className="animation-show">
                <h1 className={"page-title"}>Active orders</h1>
                {jsonResult.data.map((order, index) => (
                    <Collapsible key={index} content={order.customer.name} time={order.formattedDateTime}>
                        <div className="order-container">
                            <table>
                                <tbody>
                                <tr>
                                    <td>Order Number</td>
                                    <td>{order.id}</td>
                                </tr>
                                <tr>
                                    <td>Order time</td>
                                    <td>{order.formattedDateTime}</td>
                                </tr>
                                <tr>
                                    <td>Customer Name</td>
                                    <td>{order.customer.name}</td>
                                </tr>
                                <tr>
                                    <td>Customer Adress</td>
                                    <td>{order.customer.address.cityName}, {order.customer.address.streetName} {order.customer.address.houseNumber}</td>
                                </tr>
                                <tr>
                                    <td>Phone Number</td>
                                    <td>{order.customer.phoneNumber}</td>
                                </tr>
                                <tr>
                                    <td>Total Price</td>
                                    <td>{order.totalPrice} HUF</td>
                                </tr>
                                <tr>
                                    <td>Ordered Foods</td>
                                    <td><OrderFoodsList data={order.foods}/></td>
                                </tr>
                                </tbody>
                            </table>
                            <Button className={"order-button add-button"} text={"Delete order"}
                                    url={`http://localhost:8080/api/delete-order/${order.id}`}/>
                            <Button className={"order-button add-button"} text={"Fulfilled"}
                                    url={`http://localhost:8080/api/change-order-status/${order.id}`}/>
                        </div>
                    </Collapsible>
                ))}
            </div>
        );
    }
    return (<div className="loading-box"><CircleLoader/></div>);

}

export default ActiveOrders;