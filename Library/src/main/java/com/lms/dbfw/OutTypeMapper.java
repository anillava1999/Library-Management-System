package com.lms.dbfw;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface OutTypeMapper {  // used to invoke stored procedure in oracle .. 
void mapOutType(CallableStatement callStmt)throws SQLException;
}
