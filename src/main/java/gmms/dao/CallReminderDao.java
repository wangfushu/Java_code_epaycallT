package gmms.dao;

import gmms.domain.db.CallReminder;
import gmms.domain.query.FeeKindQueryParam;
import gmms.domain.query.KindQueryParam;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


/**
 * Created by yangjb on 2017/9/21.
 * hello
 */
public interface CallReminderDao extends BaseDao<CallReminder, String> {
    CallReminder findById(String Id);

    @Query(value = "select id from CallReminder cr where id like ? order by id desc")
    List<String> findAllNo( String id);

    @Query(value = "select cr.vehicleType, count(id) as number from CallReminder cr  where userID=? and checkTime >= ?  group by vehicleType")
    List<KindQueryParam> queryNumbyVehiclKind(Long eId,Date date);

    @Query(value = "select cr.vehicleType, sum(fee) as fee from CallReminder cr  where userID=? and checkTime >= ?  group by vehicleType")
    List<FeeKindQueryParam> queryFeebyVehiclKind(Long eId,Date date);

    @Query(value = "select sum(fee) from CallReminder where userID=? and checkTime >= ?  and isFee=1")
    Double queryTotalFeeByEid(Long eid,Date date);

    @Query(value="select * from Call_Reminder where UserID=? and isFee=1 and convert(varchar(7),FeeTime,25) =? ",nativeQuery=true)
    List<CallReminder>  queryIsFeeCallReminder(Long eId,String date);


    @Query(value="select * from Call_Reminder where UserID=? and isFee=1 and FeeTime>= ? and FeeTime<= ?",nativeQuery=true)
    List<CallReminder>  queryIsFeeCallReminderbyStartTimetoTime(Long eId,String startTime,String endTime);

    List<CallReminder> findByPlateNoAndPlateColorAndVehicleType(String plateNo,String plateColor,Long vehicleType);

}
