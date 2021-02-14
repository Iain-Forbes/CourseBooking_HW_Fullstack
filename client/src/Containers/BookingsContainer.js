import BookingList from "../components/Bookings/BookingList"

const BookingsContainer = ({bookings}) => {

    return(
        <div>
            <h1>Bookings</h1>
                <div className="bookings">
                    <BookingList bookings={bookings}/>
                </div>
        </div>
    )
}

export default BookingsContainer;