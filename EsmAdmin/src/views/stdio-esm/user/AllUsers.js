import React, { useState, useEffect } from 'react'
import moment from 'moment'
import './AllUsers.scss'
import {
  CAvatar,
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CImage,
  CProgress,
  CRow,
  CTable,
  CTableBody,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
  CPagination,
  CPaginationItem,
  CInputGroup,
  CInputGroupText,
  CFormInput,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'
import {
  cibCcAmex,
  cibCcApplePay,
  cibCcMastercard,
  cibCcPaypal,
  cibCcStripe,
  cibCcVisa,
  cifBr,
  cifEs,
  cifFr,
  cifIn,
  cifPl,
  cifUs,
  cilPeople,
  cilSearch,
} from '@coreui/icons'

import avatar1 from 'src/assets/images/avatars/1.jpg'
import avatar2 from 'src/assets/images/avatars/2.jpg'
import avatar3 from 'src/assets/images/avatars/3.jpg'
import avatar4 from 'src/assets/images/avatars/4.jpg'
import avatar5 from 'src/assets/images/avatars/5.jpg'
import avatar6 from 'src/assets/images/avatars/6.jpg'
import avt from 'src/assets/images/avatars/default-avatar.jpg'
import axios from 'axios'

const AllUsers = () => {
  const random = (min, max) => Math.floor(Math.random() * (max - min + 1) + min)
  const [users, setUsers] = useState([])
  const [currentPage, setCurrentPage] = useState(0)
  const [totalPages, setTotalPages] = useState()
  const [userPerPage, setUserPerPage] = useState([])
  const [valueSkill, setValueSkill] = useState(70)

  useEffect(() => {
    axios
      .get('users/list-users-pagination?pageNumber=' + currentPage + '&pageSize=' + userPerPage)
      .then((response) => response.data)
      .then((data) => {
        setUsers(data.content)
        setTotalPages(data.totalPages)
      })
      .catch((error) => {
        console.log(error)
      })
  }, [currentPage])

  const numberOfPages = () => {
    const page = []
    for (let i = 0; i < totalPages; i++) {
      page.push(
        <CPaginationItem
          active={i === currentPage ? true : false}
          onClick={() => changePage(i)}
          key={i}
        >
          {i + 1}
        </CPaginationItem>,
      )
    }
    return page
  }

  const changePage = (index) => {
    setCurrentPage(index)
  }

  const nextPage = () => {
    setCurrentPage(currentPage + 1)
  }

  const prePage = () => {
    setCurrentPage(currentPage - 1)
  }

  return (
    <>
      <CRow>
        <CCol xs>
          <CCard className="mb-4">
            <CCardHeader>User Lists</CCardHeader>
            <CCardBody className="card-body">
              {/* <CInputGroup className="mb-3 search-input">
                <CInputGroupText id="basic-addon1">
                  <CIcon icon={cilSearch} />
                </CInputGroupText>
                <CFormInput
                  placeholder="Search"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
              </CInputGroup> */}

              <CTable align="middle" className="mb-0 border" hover responsive>
                <CTableHead color="light">
                  <CTableRow>
                    <CTableHeaderCell className="text-center">
                      <CIcon icon={cilPeople} />
                    </CTableHeaderCell>
                    <CTableHeaderCell>User</CTableHeaderCell>
                    <CTableHeaderCell className="text-center">Address</CTableHeaderCell>
                    <CTableHeaderCell>Skill</CTableHeaderCell>
                    <CTableHeaderCell className="text-center">Project</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  {users.map((item, index) => (
                    <CTableRow v-for="item in tableItems" key={index}>
                      <CTableDataCell className="text-center">
                        <CAvatar size="md" src={avt} />
                      </CTableDataCell>
                      <CTableDataCell className="name-row">
                        <div>{item.username}</div>
                        <div className="small text-medium-emphasis">
                          Name: {item.employee.name}{' '}
                        </div>
                        <div className="small text-medium-emphasis">
                          Registered: {moment(item.createdAt).format('MM/DD/YYYY')}
                        </div>
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        <p>
                          {item.employee.address}
                          {item.id}
                        </p>
                      </CTableDataCell>
                      <CTableDataCell>
                        <div className="clearfix">
                          <div className="float-start">
                            <strong>Java</strong>
                          </div>
                          <div className="float-end">
                            <small className="text-medium-emphasis">70%</small>
                          </div>
                        </div>
                        <CProgress thin color="danger" value={valueSkill} />
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        <p>--</p>
                      </CTableDataCell>
                    </CTableRow>
                  ))}
                </CTableBody>
              </CTable>
            </CCardBody>
          </CCard>
          <CPagination className="pagination" align="center" aria-label="Page navigation example">
            <CPaginationItem disabled={currentPage < 1 ? true : false} onClick={() => prePage()}>
              Previous
            </CPaginationItem>
            {numberOfPages()}
            <CPaginationItem
              disabled={currentPage >= totalPages - 1 ? true : false}
              onClick={() => nextPage()}
            >
              Next
            </CPaginationItem>
          </CPagination>
        </CCol>
      </CRow>
    </>
  )
}

export default AllUsers
