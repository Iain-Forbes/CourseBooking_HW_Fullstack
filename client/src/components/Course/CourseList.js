import Course from './Course'

const CourseList = ({courses}) => {

    const courseList = courses.map((course) => {

        return(
            <Course course={course} key={course.id} />
        )
    })

    return(
        <>
            <ul id="list">
                {courseList}
            </ul>
        </>
    )
}
export default CourseList;
