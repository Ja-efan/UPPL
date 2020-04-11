package com.example.packetdatahcv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import io.pkts.Pcap;
import io.pkts.packet.IPPacket;
import io.pkts.packet.Packet;
import io.pkts.protocol.Protocol;

public class MainActivity extends AppCompatActivity {

    TextView tv = (TextView)findViewById(R.id.textview);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Pcap pcap = Pcap.openStream("C:\\Users\\jaehwan\\Desktop\\1130.pcap");
            pcap.loop((final Packet packet)-> {

                for(int i =0;i<100;i++) {

                    if(packet.hasProtocol(Protocol.IPv4)) {
                        IPPacket ip = (IPPacket)packet.getPacket(Protocol.IPv4);

                        String dstip = ip.getDestinationIP();
                        tv.setText(i +"  dstip: "+ dstip);

                        String srcip = ip.getSourceIP();
                        tv.setText(i +"  srcip: "+ srcip);

                        String payload = ip.getPayload().dumpAsHex();
                        tv.setText(i +"  payload: "+ payload);

                        long packetTime = ip.getArrivalTime();
                        tv.setText(i +"  Time: "+ packetTime);

                        boolean isFragment = ip.isFragmented();
                        tv.setText(i +"  isFragment: "+ isFragment);
                    }

                }

                return true;

            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
