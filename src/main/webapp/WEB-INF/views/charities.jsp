<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach begin="1" end="2" step="1" varStatus="count">
    <c:if test="${count.first}">
        <li>
            <c:forEach items="${charities}" var="charity" begin="0" end="1" step="1">
                <div class="col">
                    <div class="title">${charity.name}</div>
                    <div class="subtitle">${charity.description}</div>
                </div>
            </c:forEach>
        </li>
    </c:if>
    <c:if test="${count.last}">
        <li>
            <c:forEach items="${charities}" var="charity" begin="2" end="3" step="1">
                <div class="col">
                    <div class="title">${charity.name}</div>
                    <div class="subtitle">${charity.description}</div>
                </div>
            </c:forEach>
        </li>
    </c:if>
</c:forEach>

<c:forEach items="${charities}" var="charity" varStatus="count">
    <c:if test="${count.count%2>0}">
        <li>
    </c:if>
    <div class="col">
        <div class="title">${charity.name}</div>
        <div class="subtitle">${charity.description}</div>
    </div>
    <c:if test="${count.count%2==0}">
        </li>
    </c:if>
</c:forEach>
