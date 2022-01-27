function OrderFoodsList(props) {
    return (
        <ul>
            {props.data.map((food, index) => <li key={index}>{food.name}</li>)}
        </ul>
    );
}

export default OrderFoodsList;