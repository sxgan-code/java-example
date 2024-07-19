/**
 * 定位类型枚举
 * @param str
 * @param type
 */
export enum PositionTypeEnum {
    RIGHT_BOTTOM = 'right_bottom', TOP = 'top',
}

const init = (position: PositionTypeEnum) => {
    const msgEl = document.createElement('div')
    msgEl.setAttribute('class', 'global-msg-' + position)
    msgEl.setAttribute('id', 'zoey-message')
    msgEl.innerHTML = `
    <div class="">
      <img src="${onlineImg}"></img>
      <p>${text}</p>
    </div>
  `
    const bodyEl = document.querySelector('body')
    bodyEl?.appendChild(msgEl)
}
const destory = () => {
    const msgEl = document.getElementById('zoey-message')
    const bodyEl = document.querySelector('body')
    if (msgEl)
        bodyEl?.removeChild(msgEl)
}

let onlineImg = ''
let text = ''

// svg转base64网站：https://www.fengjs.com/tools/svg2path.html
const imgSuccess: string = 'data:image/svg+xml;charset=utf-8;base64,PHN2ZyB2aWV3Qm94PScwIDAgMTAyNCAxMDI0JyB2ZXJzaW9uPScxLjEnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZycgeG1sbnM6eGxpbms9J2h0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsnIHdpZHRoPScyMDAnIGhlaWdodD0nMjAwJz48cGF0aCBkPSdNNTEyIDg1LjMzMzMzM2MyMzUuNjQ4IDAgNDI2LjY2NjY2NyAxOTEuMDE4NjY3IDQyNi42NjY2NjcgNDI2LjY2NjY2N3MtMTkxLjAxODY2NyA0MjYuNjY2NjY3LTQyNi42NjY2NjcgNDI2LjY2NjY2N1M4NS4zMzMzMzMgNzQ3LjY0OCA4NS4zMzMzMzMgNTEyIDI3Ni4zNTIgODUuMzMzMzMzIDUxMiA4NS4zMzMzMzN6IG0tNzQuOTY1MzMzIDU1MC40TDM0Ni40NTMzMzMgNTQ1LjE1MmE0Mi42NjY2NjcgNDIuNjY2NjY3IDAgMSAwLTYwLjMzMDY2NiA2MC4zMzA2NjdsMTIwLjcwNCAxMjAuNzA0YTQyLjY2NjY2NyA0Mi42NjY2NjcgMCAwIDAgNjAuMzMwNjY2IDBsMzAxLjY1MzMzNC0zMDEuNjk2YTQyLjY2NjY2NyA0Mi42NjY2NjcgMCAxIDAtNjAuMjg4LTYwLjMzMDY2N2wtMjcxLjUzMDY2NyAyNzEuNDg4eicgZmlsbD0nIzUyQzQxQSc+PC9wYXRoPjwvc3ZnPg=='
const imgWarning: string = 'data:image/svg+xml;charset=utf-8;base64,PHN2ZyB2aWV3Qm94PScwIDAgMTAyNCAxMDI0JyB2ZXJzaW9uPScxLjEnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZycgaWQ9J214X25fMTcyMTM2OTE4NzkxOCcgd2lkdGg9JzIwMCcgaGVpZ2h0PScyMDAnPjxwYXRoIGQ9J001MTIgNTEybS00MDMuMiAwYTQwMy4yIDQwMy4yIDAgMSAwIDgwNi40IDAgNDAzLjIgNDAzLjIgMCAxIDAtODA2LjQgMFonIGZpbGw9JyNGOUQ2NUQnPjwvcGF0aD48cGF0aCBkPSdNNTEyIDYwOGMtMTkuMiAwLTM4LjQtMTkuMi0zOC40LTM4LjRWMjg4YzAtMTkuMiAxOS4yLTM4LjQgMzguNC0zOC40czM4LjQgMTkuMiAzOC40IDM4LjRWNTc2YzAgMTIuOC0xOS4yIDMyLTM4LjQgMzJ6JyBmaWxsPScjRkZGRkZGJz48L3BhdGg+PHBhdGggZD0nTTUxMiA3MzZtLTQ0LjggMGE0NC44IDQ0LjggMCAxIDAgODkuNiAwIDQ0LjggNDQuOCAwIDEgMC04OS42IDBaJyBmaWxsPScjRkZGRkZGJz48L3BhdGg+PC9zdmc+'
const imgError: string = 'data:image/svg+xml;charset=utf-8;base64,PHN2ZyB2aWV3Qm94PScwIDAgMTAyNCAxMDI0JyB2ZXJzaW9uPScxLjEnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZycgeG1sbnM6eGxpbms9J2h0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsnIHdpZHRoPScyMDAnIGhlaWdodD0nMjAwJz48cGF0aCBkPSdNNTEyIDk4MS4zMzMzMzNDMjUyLjggOTgxLjMzMzMzMyA0Mi42NjY2NjcgNzcxLjIgNDIuNjY2NjY3IDUxMlMyNTIuOCA0Mi42NjY2NjcgNTEyIDQyLjY2NjY2N3M0NjkuMzMzMzMzIDIxMC4xMzMzMzMgNDY5LjMzMzMzMyA0NjkuMzMzMzMzLTIxMC4xMzMzMzMgNDY5LjMzMzMzMy00NjkuMzMzMzMzIDQ2OS4zMzMzMzN6IG00NC4yNDUzMzMtNDY5LjMzMzMzM2wxNTkuOTE0NjY3LTE1OS45MTQ2NjdhMzEuMjc0NjY3IDMxLjI3NDY2NyAwIDEgMC00NC4yNDUzMzMtNDQuMjQ1MzMzTDUxMiA0NjcuNzU0NjY3IDM1Mi4wODUzMzMgMzA3Ljg0YTMxLjI3NDY2NyAzMS4yNzQ2NjcgMCAxIDAtNDQuMjQ1MzMzIDQ0LjI0NTMzM0w0NjcuNzU0NjY3IDUxMmwtMTU5LjkxNDY2NyAxNTkuOTE0NjY3YTMxLjI3NDY2NyAzMS4yNzQ2NjcgMCAxIDAgNDQuMjQ1MzMzIDQ0LjI0NTMzM0w1MTIgNTU2LjI0NTMzM2wxNTkuOTE0NjY3IDE1OS45MTQ2NjdhMzEuMjc0NjY3IDMxLjI3NDY2NyAwIDEgMCA0NC4yNDUzMzMtNDQuMjQ1MzMzTDU1Ni4yNDUzMzMgNTEyeicgZmlsbD0nI0Y1MjIyRCc+PC9wYXRoPjwvc3ZnPg=='
const imgNote: string = 'data:image/svg+xml;charset=utf-8;base64,PHN2ZyB2aWV3Qm94PScwIDAgMTAyNCAxMDI0JyB2ZXJzaW9uPScxLjEnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2Zycgd2lkdGg9JzIwMCcgaGVpZ2h0PScyMDAnPjxwYXRoIGQ9J002MjggNzkuMjdjLTIzOS02NC00ODQuNjUgNzcuNzktNTQ4LjY4IDMxNi43OHM3Ny43NCA0ODQuNjUgMzE2LjczIDU0OC42OFM4ODAuNyA4NjYuOTQgOTQ0LjczIDYyOCA4NjYuOTQgMTQzLjMgNjI4IDc5LjI3ek01MTIgMjA4YTM2IDM2IDAgMSAxLTM2IDM2IDM2IDM2IDAgMCAxIDM2LTM2eiBtNjYuODcgMTkzLjU0bC05MC4yIDMzNi42M2E5MC4yNCA5MC4yNCAwIDAgMCA2Mi45Mi00MS4zNCAxMS4xNSAxMS4xNSAwIDAgMSAyMC40MSA4LjQxbC02LjQ0IDI0YTEwOCAxMDggMCAwIDEtMTMyLjI3IDc2LjM3IDM2IDM2IDAgMCAxLTI1LjQ1LTQ0LjA5bDkwLjItMzM2LjYzYTkwLjI4IDkwLjI4IDAgMCAwLTYyLjkyIDQxLjM0IDExLjE1IDExLjE1IDAgMCAxLTIwLjQ0LTguNDFsNi40NC0yNGExMDggMTA4IDAgMCAxIDEzMi4yNy03Ni4zNyAzNiAzNiAwIDAgMSAyNS40OCA0NC4wOXonIGZpbGw9JyM4YThhOGEnPjwvcGF0aD48L3N2Zz4='
/**
 *  消息提示框
 *  实例：
 *
 */
const message = {
    success: (msg = '成功', position: PositionTypeEnum = PositionTypeEnum.RIGHT_BOTTOM,
              time = 2, callback = () => {
            return
        }) => {
        onlineImg = imgSuccess
        text = msg
        init(position)
        setTimeout(() => {
            destory()
            callback()
        }, time * 1000);
    },
    warning: (msg = '警告', position: PositionTypeEnum = PositionTypeEnum.RIGHT_BOTTOM,
              time = 2, callback = () => {
            return
        }) => {
        onlineImg = imgWarning
        text = msg
        init(position)
        setTimeout(() => {
            destory()
            callback()
        }, time * 1000);
    },
    error: (msg = '服务器端异常，请稍后再试', position: PositionTypeEnum = PositionTypeEnum.TOP,
            time = 2, callback = () => {
            return
        }) => {
        onlineImg = imgError
        text = msg
        init(position)
        setTimeout(() => {
            destory()
            callback()
        }, time * 1000);
    },
    note: (msg = '提示', position: PositionTypeEnum = PositionTypeEnum.TOP,
           time = 2, callback = () => {
            return
        }) => {
        onlineImg = imgNote
        text = msg
        init(position)
        setTimeout(() => {
            destory()
            callback()
        }, time * 1000);
    },
}

export default message