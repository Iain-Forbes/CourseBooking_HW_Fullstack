import Customer from "./Customer"

const CustomerList = ({customers}) => {

    const custList = customers.map((customer) => {

        return (
            <Customer 
                customer={customer}
                key={customer.id} />
        )
    })

    return (
        <>
            <ul id="list">
                {custList}
            </ul>
        </>
    )
}

export default CustomerList;