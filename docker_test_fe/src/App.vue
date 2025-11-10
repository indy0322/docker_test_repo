<template>
  <div class="calculator">
    <h2>덧셈 계산기 ➕</h2>

    <!-- 입력 영역 -->
    <div class="inputs">
      <input
        v-model="a"
      />
      <input
        v-model="b"
      />
      <button @click="add" class="primary">더하기 (두 수)</button>
    </div>

    <div>
      {{result}}
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import axios from 'axios'

const a = ref('')
const b = ref('')

const result = ref(0)

// 두 수 더하기 (버튼)
async function add() {
  const n1 = a.value
  const n2 = b.value
  if (Number.isNaN(n1) || Number.isNaN(n2)) {
    alert('유효한 숫자 두 개를 입력하세요.')
    return;
  }

  const data = {
    num1: n1,
    num2: n2
  }
  await axios.post('http://localhost/calc/add',data).then(
    (res) => {
      result.value = res.data;
    }
  )
  
}
</script>

<style scoped>
.calculator {
  max-width: 720px;
  margin: 28px auto;
  background: #fff;
  padding: 18px;
  border-radius: 12px;
  box-shadow: 0 6px 24px rgba(30, 40, 50, 0.06);
  font-family: "Segoe UI", Roboto, "Noto Sans KR", sans-serif;
}
h2 { margin: 0 0 12px 0; font-size: 1.3rem; }
.inputs {
  display: flex;
  gap: 8px;
  align-items: center;
  margin-bottom: 8px;
}
.inputs input {
  flex: 1;
  padding: 10px 12px;
  border-radius: 8px;
  border: 1px solid #e0e6ef;
  font-size: 0.95rem;
}
button {
  padding: 10px 12px;
  border-radius: 8px;
  border: none;
  cursor: pointer;
  font-weight: 600;
}
button.primary { background: #2f80ed; color: white; }
button.secondary { background: #edf2ff; color: #1f3b8a; border: 1px solid #dbe6ff; }
button.danger { background: #ffefef; color: #c43434; border: 1px solid #ffdcdc; }

.error {
  color: #b00020;
  margin-bottom: 8px;
}

.result {
  display: flex;
  gap: 12px;
  margin: 12px 0;
  align-items: center;
}
.box {
  background: #f6f9ff;
  padding: 8px 12px;
  border-radius: 8px;
  border: 1px solid #eef5ff;
}
.value { font-size: 1.05rem; margin-left: 8px; font-weight: 700; }

.list-area {
  margin-top: 12px;
  border-top: 1px dashed #eef2f6;
  padding-top: 12px;
}
.controls { display:flex; gap:8px; align-items:center; margin-bottom:8px; }
.list { list-style: none; padding: 0; margin: 0 0 8px 0; }
.list li {
  display:flex;
  justify-content:space-between;
  gap: 12px;
  padding: 6px 8px;
  border-radius: 8px;
  background: #fff;
  border: 1px solid #f0f3f6;
  margin-bottom: 6px;
  align-items:center;
}
.tiny {
  padding: 6px 8px;
  font-size: 0.8rem;
  border-radius: 6px;
  background: #f3f5f7;
  border: 1px solid #e6e9ec;
  cursor: pointer;
}

.muted { color: #8b96a6; font-size: 0.95rem; }

.history { margin-top: 14px; border-top: 1px dashed #eef2f6; padding-top: 12px; }
.history ul { padding-left: 16px; margin: 8px 0; }
</style>
