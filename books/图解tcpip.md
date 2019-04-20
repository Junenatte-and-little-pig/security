# 图解TCP/IP
【日】竹下隆史，村山公保，荒井透，苅田幸雄 著

---
## 计算机网络基础知识
### 计算机和计算机网络发展的六个阶段
- 批处理
- 分时系统(TSS)
- 计算机之间的通信
- 计算机网络的产生
- Internet的普及
- Internet技术的时代
### 协议
|通信体系|协议|用途|
|:-----:|:--:|:-:|
|TCP/IP|IP, ICMP, TCP, UDP, HTTP, TELNET, SNMP, SMTP,...|Internet|
|Net-Ware|IPX, SPX, NPC,...|微机LAN|
|Apple-Talk|DDP, RTMP, AEP, ATP, ZIP,...|Macintosh LAN|
|DECnet|DPR, NSP, SCP,...|旧DEC公司的小型机等|
|OSI|FTAM, MOTIS, VT, CMIS/CMIP, CLNP, CONP,...||
|XNS|IDP, SPP, PEP,...|Xerox公司的计算机网络|
### 包交换
&emsp;&emsp;在网络通信的时候相互之间传送的数据是通过分割成一个个小包进行传输的，而在交换包的时候，要遵循一定的协议才能保证交换的时候保证不发生错误。
### 会话
&emsp;&emsp;两个主机之间发生的活动，会话中包含不止一次的通信，通信需要将数据进行交换，交换时需要遵循一定的协议，只有这一系列的过程都没问题，整个会话才能成功。
### 标准化
&emsp;&emsp;为了能够使各个使用者能够在不同的设备之间实现通信，需要将各厂家指定的协议进行标准化，才能让各参与者方便的参与到网络中去。
### 分层化
&emsp;&emsp;分层是指将主机功能进行分割，每一层与邻近层之间通过接口进行交互，同层之间通过协议进行约束。  
&emsp;&emsp;在OSI(Open System Interconnection 开放系统互联)参考模型中将网络通信过程分为七层，自上至下分为：
- 应用层：将特定的应用进行处理的协议；
- 表示层：计算机固有的数据格式，与计算机网络公共的数据格式的交换；
- 会话层：通信的管理。建立/确定切断连接，对传输层以下的各层进行管理；
- 传输层：两个节点之间数据传输的管理。提供数据传输的可靠性；
- 网络层：地址的管理和路由的选择；
- 数据链路层：直接连接的计算机之间数据帧的识别和传输；
- 物理层：规定了连接器和电缆的形状。

&emsp;&emsp;数据在源主机的应用层产生，层层向下传递并打包，与路由器经由物理层连接，路由之间通过网络层传输数据包，再经由物理层到达目标主机，最后层层解析到达目标主机的应用层。
## TCP/IP协议的基础知识
### TCP/IP分层及部分相关协议
- 应用层：对应OSI中的应用层、表示层及会话层，有HTTP(HyperText Transfer Protocol)、SMTP(Simple Mail Transfer Protocol)、FTP(File Transfer Protocol)、TELNET、SNMP(Simple Network Management Protocol)等；
- 传输层：对应OSI中的传输层，有TCP(Yransmission Control Protocol)、UDP(User Data Protocol)等；
- Internet层：对应OSI中的网络层，有IP(Internet Protocol)、ICMP(Internet Control Message Protocol)、ARP(Address Resolution Protocol)等；
- 网络接口层：对应OSI中的数据链路层；
- 硬件：对应OSI中的物理层。

&emsp;&emsp;其中，应用层对应计算机中的应用程序，传输层和Internet层对应计算机中的操作系统，网络接口层和硬件对应计算机中的设备驱动器和网络接口。
## 数据链路层
&emsp;&emsp;数据链路层的协议规定了在直接相连的计算机之间使用通信介质进行通信的规格标准。
- MAC地址：用于识别数据链路上连接的节点而设置的；
- 计算机网络
  + 共享传输介质：指各工作站之间通过竞争或者令牌传递的方式，共用一条传输介质，为了防止产生冲突，所以只能采取半双工通信，使用的协议有Ethernet和FDDI；
  + 非共享传输介质：通过专有传输介质进行通信，因为是专有传输介质，所以可以采取全双工通信，使用的协议有ATM和PPP；
### 四个主要协议
- Ethernet：特征是采用CSMA/DA方式，可以通过载波侦听实现多路访问，也可以检测是否发生了冲突；
- FDDI(Fiber Distributed Data Interface 管线分布式数据接口)：特征是采用了令牌传递方式，能很好地控制各个工作站发送数据的顺序，也就避免了冲突的发生；
- ATM(Asynchronous Transfer Mode 异步传输方式)：采用非同步的多路复用，实现对线路利用率的提高。但是由于ATM发送的数据太少，所以往往要加上AAL(ATM Adaptation Layer ATM适配器分层)，来实现大量的数据传输。特征是面向连接；
- PPP(Point-to-Point Protocol 点到点协议)：需要进行通信双方的认证，主要有PAP(Password Authentication Protocol 口令认证协议)和CHAP(Challenge Handshake Authentication Protocol 挑战握手认证协议)。在实际应用中通常采用PPPoE(PPP over Ethernet)的方式实现容易方便且安全的管理。
### 其他协议
- Token Ring
- 100VG-AnyLAN
- fiber channel
- HIPPI
- IEEE1394
- IEEE802.11b
- IEEE802.11a
- Bluetooth

&emsp;&emsp;数据链路层相关的技术，一直在不断地发展之中，包括利用生成树或源路由寻址等方式实现的循环检查技术，灵活改变计算机网络结构的虚拟局域网VLAN。
## IP协议
### 三大功能
- 分配IP地址和到目的主机的包发送(路由寻址)功能
- IP包的分割处理功能
- 重新构筑处理功能
### IP地址
&emsp;&emsp;由32位二进制数组成，每8位为一组，共四组，组间由点隔开。包含计算机网络地址部分和主机地址部分。  
&emsp;&emsp;将开头一定位数进行了一些规定，从而实现将不同的IP地址类区分开来，基本分为A、B、C、D、E五类。不同类别IP地址，计算机网络地址部分与主机地址部分长度不同，也有个别类别具有其他特殊的作用，比如D类没有主机地址部分，主要用于广播通信；E类留作保留使用。  
&emsp;&emsp;当一个IP地址中，主机地址部分全为0时，代表这是一个网关地址，不指向具体的主机，用于将主机连接到互联网中。  
&emsp;&emsp;当一个IP地址中，主机地址部分全为1时，代表这是一个广播地址，则此主机的发送给所有计算机网络地址部分符合条件的的主机。  
&emsp;&emsp;因为在分类中每一类的IP地址数往往大于实际存在于同一类中的主机数，不够灵活，因此引进了子网划分的技术，并通过子网掩码实现灵活管理IP地址。  
&emsp;&emsp;为了减少早期对IP地址划分类的方法造成的地址浪费，现在通常采用CIDR(Classless Inter-Domain Routing 无类别域间路由)，实现灵活的子网划分方法，能更好的利用IP地址。  
&emsp;&emsp;为了一些特殊需要，在所有IP地址中，划分出了一些较为特殊的IP地址，人们规定它们有各自特殊的功能，以满足不同人群的需要。
## IP协议相关技术和IPv6
## TCP协议和UDP协议
## 路由控制协议
## 应用协议
## 物理层、传输介质和公众通信服务