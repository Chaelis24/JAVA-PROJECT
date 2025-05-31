<?php
include "db_connection.php";
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

                <?php
                if (isset($_GET['msg'])) {
                    $msg = htmlspecialchars($_GET['msg']);
                    echo '<div class="alert alert-warning alert-dismissible fade show m-2 px-2" role="alert">' .
                        $msg .
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
                }
                if (isset($_GET['msg2'])) {
                    $msg2 = htmlspecialchars($_GET['msg2']);
                    echo '<div class="alert alert-danger alert-dismissible fade show m-2 px-2" role="alert">' .
                        $msg2 .
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
                }
                ?>

                <div class="container py-3 text-white">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4>Active Students</h4>
                        <a href="archived_students.php" class="btn btn-secondary btn-sm">View Archived Students</a>
                    </div>
                    <div class="row justify-content-center mb-4">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-green">
                                <thead class="table-dark">
                                    <tr>
                                        <th style="width: 3%;">ID</th>
                                        <th style="width: 18%;">Full Name</th>
                                        <th style="width: 8%;">Course</th>
                                        <th style="width: 8%;">Block</th>
                                        <th style="width: 8%;">Year</th>
                                        <th style="width: 7%;">Gender</th>
                                        <th class="d-none d-md-table-cell" style="width: 12%;">Address</th>
                                        <th class="d-none d-md-table-cell" style="width: 12%;">Email</th>
                                        <th class="d-none d-md-table-cell" style="width: 8%;">Birthdate</th>
                                        <th class="d-none d-md-table-cell" style="width: 8%;">Phone</th>
                                        <th style="width: 8%;">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <?php
                                    $sql = "SELECT s.student_id, s.first_name, s.middle_name, s.last_name,
                                                p.program_name, b.block_name, y.level_name,
                                                s.gender, s.address, s.email, s.date_of_birth, s.phone_number
                                            FROM tbl_student s
                                            JOIN tbl_program p ON s.program_id = p.program_id
                                            JOIN tbl_block b ON s.block_id = b.block_id
                                            JOIN tbl_year_level y ON s.year_level_id = y.year_level_id
                                            WHERE s.is_archived = 0";

                                    $result = mysqli_query($conn, $sql) or die("Query Error: " . mysqli_error($conn));

                                    while ($row = mysqli_fetch_assoc($result)) {
                                        $full_name = trim(htmlspecialchars($row['last_name'] . ' ' . ($row['first_name'] ? $row['middle_name'] . ' ' : '') . $row['first_name']));
                                        echo "<tr>";
                                        echo "<td>" . htmlspecialchars($row['student_id']) . "</td>";
                                        echo "<td>$full_name</td>";
                                        echo "<td>" . htmlspecialchars($row['program_name']) . "</td>";
                                        echo "<td>" . htmlspecialchars($row['block_name']) . "</td>";
                                        echo "<td>" . htmlspecialchars($row['level_name']) . "</td>";
                                        echo "<td>" . htmlspecialchars($row['gender']) . "</td>";
                                        echo "<td class='d-none d-md-table-cell'>" . htmlspecialchars($row['address']) . "</td>";
                                        echo "<td class='d-none d-md-table-cell'>" . htmlspecialchars($row['email']) . "</td>";
                                        echo "<td class='d-none d-md-table-cell'>" . htmlspecialchars($row['date_of_birth']) . "</td>";
                                        echo "<td class='d-none d-md-table-cell'>" . htmlspecialchars($row['phone_number']) . "</td>";
                                        echo "<td class='action-btns p-1'>";
                                        echo "<div class='btn-group btn-group-sm'>";
                                        echo "<a href='update_student.php?student_id=" . htmlspecialchars($row['student_id']) . "' class='btn btn-outline-primary btn-sm p-0' style='padding: 0.15rem 0.3rem; font-size: 0.75rem;'>";
                                        echo "<i class='bi bi-pencil p-1'>Edit</i></a>";
                                        echo "<a href='archive_student.php?student_id=" . htmlspecialchars($row['student_id']) . "' class='btn btn-outline-danger btn-sm p-0' style='padding: 0.15rem 0.3rem; font-size: 0.75rem;' onclick=\"return confirm('Are you sure you want to archive this student?');\">";
                                        echo "<i class='bi bi-archive p-1'>Archive</i></a>";
                                        echo "</div></td>";
                                        echo "</tr>";
                                    }
                                    ?>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
