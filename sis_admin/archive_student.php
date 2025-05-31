<?php
include "db_connection.php";

if (isset($_GET['student_id'])) {
    $student_id = $_GET['student_id'];

    $sql = "UPDATE tbl_student SET is_archived = 1 WHERE student_id = $student_id";
    $result = mysqli_query($conn, query: $sql);

    if ($result) {
        header("Location: retrieve_student.php?msg=Archived Successfully!");
        exit;
    } else {
        echo "Error: " . mysqli_error($conn);
    }
} else {
    echo "No student ID provided.";
}
?>
