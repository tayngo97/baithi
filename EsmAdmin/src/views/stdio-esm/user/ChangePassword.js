import React, { useState, useEffect } from 'react'
import './ChangePassword.scss'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CFormLabel,
  CFormInput,
  CButton,
  CForm,
} from '@coreui/react'
import axios from 'axios'
const ChangePassword = () => {
  const [currentPassword, setCurrentPassword] = useState('')
  const [newPassword, setNewPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [msgError, setMsgError] = useState('')
  const [msgSuccess, setMsgSuccess] = useState('')
  const handleCurrentPassword = (event) => {
    setCurrentPassword(event.target.value)
  }

  const handleNewPassword = (event) => {
    setNewPassword(event.target.value)
  }

  const handleConfirmPassword = (event) => {
    setConfirmPassword(event.target.value)
  }

  const handleChangePassword = (event) => {
    event.preventDefault()
    if (newPassword !== confirmPassword) {
      setMsgError('Confirm password not match !')
    }

    let data = {
      id: localStorage.getItem('userId'),
      oldPassword: currentPassword,
      newPassword: newPassword,
      confirmNewPassword: confirmPassword,
    }
    console.log(data)
    axios
      .post('users/change-password', data, {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      })
      .then((res) => {
        console.log(res.data.code)
        if (res.data.code) {
          setMsgSuccess('')
          setMsgError(res.data.message)
        } else {
          setMsgSuccess(res.data)
          setMsgError('')
          setCurrentPassword('')
          setNewPassword('')
          setConfirmPassword('')
        }
      })
      .catch((err) => {
        console.log(err)
      })
  }

  return (
    <>
      <CRow>
        <CCol xs>
          <CCard className="mb-4">
            <CCardHeader>
              <strong>Change Password</strong>
            </CCardHeader>
            <CCardBody className="card-body">
              <CForm>
                {/* <CRow className="mt-3">
                  <div className="col-3"></div>
                  <div className="col-6">
                    <CFormLabel htmlFor="exampleFormControlInput1">User Name</CFormLabel>
                    <CFormInput
                      type="email"
                      id="exampleFormControlInput1"
                      placeholder="name@example.com"
                      disabled
                    />
                  </div>
                  <div className="col-3"></div>
                </CRow> */}
                <CRow className="mt-3">
                  <div className="col-3"></div>
                  <div className="col-6">
                    <CFormLabel htmlFor="exampleFormControlInput2">Current password</CFormLabel>
                    <CFormInput
                      onChange={(event) => handleCurrentPassword(event)}
                      value={currentPassword}
                      type="password"
                      id="exampleFormControlInput2"
                      required
                    />
                  </div>
                  <div className="col-3"></div>
                </CRow>
                <CRow className="mt-3">
                  <div className="col-3"></div>
                  <div className="col-6">
                    <CFormLabel htmlFor="exampleFormControlInput3">New password</CFormLabel>
                    <CFormInput
                      type="password"
                      value={newPassword}
                      id="exampleFormControlInput3"
                      onChange={(event) => handleNewPassword(event)}
                      required
                    />
                  </div>
                  <div className="col-3"></div>
                </CRow>
                <CRow className="mt-3">
                  <div className="col-3"></div>
                  <div className="col-6">
                    <CFormLabel htmlFor="exampleFormControlInput4">Confirm password</CFormLabel>
                    <CFormInput
                      type="password"
                      value={confirmPassword}
                      id="exampleFormControlInput4"
                      onChange={(event) => handleConfirmPassword(event)}
                      required
                    />
                    {msgError && <p className="error">{msgError}</p>}
                    {msgSuccess && <p className="success">{msgSuccess}</p>}
                  </div>
                  <div className="col-3"></div>
                </CRow>
                <CRow className="mt-3">
                  <div className="col-3"></div>
                  <div className="col-6">
                    <CButton
                      type="submit"
                      color="primary"
                      onClick={(event) => handleChangePassword(event)}
                    >
                      Change password
                    </CButton>
                  </div>
                  <div className="col-3"></div>
                </CRow>
              </CForm>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    </>
  )
}

export default ChangePassword
