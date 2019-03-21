 %default startDate '2019/04/16-00:30:00'
 %default endDate '2019/04/17-00:30:00'
 %default output 'myscript_output'
 A =  LOAD 'tmp' using RecordLoader('all', 'paypal', 'riskudgopserv', 'null', '$startDate', '$endDate', '100', 'INFO', 'com.paypal.risk.decision.lifecycle.servicecallers.AdminTransactionLogServDetailsDispatcher')
      as (level:int, calClass:bytearray, time:long, type:bytearray,  name:bytearray, status:bytearray, duration:float, data:bytearray, dataMap:map[]);
 B = LIMIT A 10;
 EXPLAIN B;
 STORE B into '$output' using JsonStorage();