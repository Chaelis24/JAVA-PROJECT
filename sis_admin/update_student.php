<?php
include "db_connection.php";

$student_id = intval($_GET["student_id"]);

$sql = "SELECT * FROM `tbl_student` WHERE student_id = $student_id LIMIT 1";
$result = mysqli_query($conn, $sql);
$student = mysqli_fetch_assoc($result);

if (!$student) {
    die("Student not found");
}

$programs = mysqli_query($conn, "SELECT * FROM tbl_program");
$blocks = mysqli_query($conn, "SELECT * FROM tbl_block");
$year_levels = mysqli_query($conn, "SELECT * FROM tbl_year_level");
$schools = mysqli_query($conn, "SELECT * FROM tbl_school_year");

if (isset($_POST["submit"])) {
    $firstName = $_POST["first_name"];
    $middleName = $_POST["middle_name"];
    $lastName = $_POST["last_name"];
    $gender = $_POST["gender"];
    $address = $_POST["address"];
    $email = $_POST["email"];
    $dateOfBirth = $_POST["date_of_birth"];
    $phoneNumber = $_POST["phone_number"];
    $program_id = $_POST["program_id"];
    $block_id = $_POST["block_id"];
    $year_level_id = $_POST["year_level_id"];
    $school_year_id = $_POST["school_year_id"];

    $sql = "UPDATE `tbl_student` SET 
        `email` = '$email',
        `phone_number` = '$phoneNumber',
        `address` = '$address',
        `program_id` = '$program_id',
        `block_id` = '$block_id'
        WHERE student_id = $student_id";

    $result = mysqli_query($conn, $sql);

    if ($result) {
        header("Location: retrieve_student.php?msg=Updated Successfully");
        exit;
    } else {
        echo "Failed: " . mysqli_error($conn);
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Student Information System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <div class="offcanvas offcanvas-start d-md-none bg-dark text-white" tabindex="-1" id="sidebar" aria-labelledby="sidebarLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="sidebarLabel">Menu</h5>
            <button type="button" class="btn-close btn-close-white text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <div class="text-center mb-4">
                <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
            </div>
            <ul class="nav flex-column sidebar">
                <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                <li class="nav-item py-3"><a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a></li>
            </ul>
        </div>
    </div>

    <div class="container-fluid px-0">
        <div class="row g-0">
            <nav class="d-none d-md-flex col-md-3 col-lg-2 bg-dark text-white flex-column p-3" style="min-height: 100vh;">
                <div class="text-center mb-4">
                    <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
                </div>
                <ul class="nav flex-column sidebar">
                    <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                    <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                    <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                    <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                </ul>
                <div class="mt-auto pt-3">
                    <a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a>
                </div>
            </nav>

            <main class="col-md-9 col-lg-10">
                <header class="d-flex justify-content-between align-items-center p-3" style="background-color: #108500;">
                    <div class="d-flex align-items-center text-white">
                        <button class="btn btn-light d-md-none me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebar" aria-controls="sidebar" aria-label="Toggle sidebar">
                            <i class="bi bi-list"></i>
                        </button>
                        <div>
                            <h5 class="mb-0">Top Link Global College, Inc.</h5>
                            <small>Liwag Building, Cabanatuan City, Nueva Ecija</small>
                        </div>
                    </div>
                    <div class="d-flex align-items-center" style="font-size: 0.85rem;">
                        <img src="img/admin.png" alt="Admin" class="img-circle-sm img-fluid" style="width:30px; height:30px; object-fit:cover;" />
                        <span class="text-white fw-bold ms-2">Admin</span>
                    </div>
                </header>

                <div class="container py-4 text-white">
                    <div class="row justify-content-center mb-4">
                        <form action="" method="POST" class="needs-validation" novalidate>
                            <div class="container">
                                <h3 class="text-center mb-4">Update Student</h3>

                                <h5>Student Name</h5>
                                <div class="row g-3 mb-3">
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" id="first_name" name="first_name" value="<?= htmlspecialchars($student['first_name']) ?>" required readonly>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" id="middle_name" name="middle_name" value="<?= htmlspecialchars($student['middle_name']) ?>" readonly>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" id="last_name" name="last_name" value="<?= htmlspecialchars($student['last_name']) ?>" required readonly>
                                    </div>
                                </div>

                                <div class="row g-3 mb-3">
                                    <div class="col-md-4">
                                        <label for="email" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="email" name="email" value="<?= htmlspecialchars($student['email']) ?>" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="phone_number" class="form-label">Phone Number</label>
                                        <input type="tel" class="form-control" id="phone_number" name="phone_number" value="<?= htmlspecialchars($student['phone_number']) ?>" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="address" class="form-label">Address</label>
                                        <textarea class="form-control" id="address" name="address" rows="1" required><?= htmlspecialchars($student['address']) ?></textarea>
                                    </div>
                                </div>

                                <div class="row g-3 mb-3">
                                    <div class="col-md-4">
                                        <label for="date_of_birth" class="form-label">Birthdate</label>
                                        <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" value="<?= htmlspecialchars($student['date_of_birth']) ?>" required readonly>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="gender" class="form-label">Gender</label>
                                        <select class="form-select" id="gender" name="gender" required disabled>
                                            <option value="" disabled <?= empty($student['gender']) ? 'selected' : '' ?>>Select gender</option>
                                            <option value="Male" <?= ($student['gender'] === 'Male') ? 'selected' : '' ?>>Male</option>
                                            <option value="Female" <?= ($student['gender'] === 'Female') ? 'selected' : '' ?>>Female</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4"></div>
                                </div>

                            <div class="row mt-2 g-3">
                                <div class="col-12 col-md-3">
                                    <label class="form-label">Course</label>
                                    <select class="form-select" name="program_id" required>
                                        <option value="">Select Course</option>
                                        <?php
                                        mysqli_data_seek($programs, 0);
                                        while ($row = mysqli_fetch_assoc($programs)) { ?>
                                            <option value="<?= $row['program_id'] ?>" <?= ($student['program_id'] == $row['program_id']) ? 'selected' : '' ?>>
                                                <?= $row['program_name'] ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label class="form-label">Block</label>
                                    <select class="form-select" name="block_id" required>
                                        <option value="">Select Block</option>
                                        <?php
                                        mysqli_data_seek($blocks, 0);
                                        while ($row = mysqli_fetch_assoc($blocks)) { ?>
                                            <option value="<?= $row['block_id'] ?>" <?= ($student['block_id'] == $row['block_id']) ? 'selected' : '' ?>>
                                                <?= $row['block_name'] ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label class="form-label">Year Level</label>
                                    <select class="form-select" name="year_level_id" required disabled>
                                        <option value="">Select Year Level</option>
                                        <?php
                                        mysqli_data_seek($year_levels, 0);
                                        while ($row = mysqli_fetch_assoc($year_levels)) { ?>
                                            <option value="<?= $row['year_level_id'] ?>" <?= ($student['year_level_id'] == $row['year_level_id']) ? 'selected' : '' ?>>
                                                <?= $row['level_name'] ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label class="form-label">School Year</label>
                                    <select class="form-select" name="school_year_id" required disabled>
                                        <option value="">Select School Year</option>
                                        <?php
                                        mysqli_data_seek($schools, 0);
                                        while ($row = mysqli_fetch_assoc($schools)) { ?>
                                            <option value="<?= $row['school_year_id'] ?>" <?= ($student['school_year_id'] == $row['school_year_id']) ? 'selected' : '' ?>>
                                                <?= $row['year_label'] ?>
                                            </option>
                                        <?php } ?>
                                    </select>
                                </div>
                            </div>

                            <div class="row mt-4">
                                <div class="col-12 d-flex flex-column flex-md-row justify-content-md-end gap-2">
                                    <button type="submit" class="btn bg-primary text-white" name="submit">Update Student</button>
                                    <a href="index.php" class="btn bg-danger text-white">Cancel</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
